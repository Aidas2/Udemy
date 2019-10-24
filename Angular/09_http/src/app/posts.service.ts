import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpEventType } from '@angular/common/http';
import { map, catchError, tap } from 'rxjs/operators';
import { Subject, throwError } from 'rxjs';

import { Post } from './post.model';

@Injectable({ providedIn: 'root' })
export class PostsService {

  error = new Subject<string>();  // for using when subscribing not in app.component.ts

  constructor(private http: HttpClient) { }

  createAndStorePost(title: string, content: string) {
    const postData: Post = { title: title, content: content };
    this.http
      .post<{ name: string }>(
        'https://recipe-book-2b037.firebaseio.com/posts.json',
        postData,
        {
          observe: 'response'      // defaul is 'body', may be response, events
        }
      )
      .subscribe(                // subscribe not moved (becouse we  don't care about answer)
        responseData => {
          console.log(responseData);
        },
        error => {
          this.error.next(error.message);  // emitting error message

        });
  }

  fetchPosts() {

    let searchParams = new HttpParams();
    searchParams = searchParams.append('print', 'pretty');
    searchParams = searchParams.append('custom', 'key');

    return this.http
      .get<{ [key: string]: Post }>(
        'https://recipe-book-2b037.firebaseio.com/posts.json',
        {
          headers: new HttpHeaders({ 'Custom-Header': 'Hello' }),
          // params: new HttpParams().set('print', 'pretty')
          params: searchParams,
          responseType: 'json'   // defaul is json, may be text, blob
        }
      )
      // goal: convert object to array of posts:
      .pipe(
        map((responseData) => {
          const postsArray: Post[] = [];
          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              postsArray.push({ ...responseData[key], id: key });
            }
          }
          return postsArray;
        }),
        catchError(errorResp => {
          // Send to analytics server
          return throwError(errorResp);

        })
      );
    // .subscribe(posts => {    // subscribe  moved in to the app.component.ts (becouse we  care about answer) !!! therefore 'return' is added to enable this
    //   console.log(posts);
    //   // this.isFetching = false;
    //   // this.loadedPosts = posts;
    // });
  }

  deletePosts() {
    return this.http
      .delete(
        'https://recipe-book-2b037.firebaseio.com/posts.json',
        {
          observe: 'events',  // defaul is 'body', may be response, events
          responseType: 'text'  // defaul is json, may be text, blob

        }
      ).pipe(tap(event => {      // tap is only for not disturbing subcribe()
        console.log(event);
        // checking if did I get response, etc. (by comparing code numbers)
        if (event.type === HttpEventType.Sent) {
          // ...
        }
        if (event.type === HttpEventType.Response) {
          console.log(event.body);
        }
      }));
  }

}
