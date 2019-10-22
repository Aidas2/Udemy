import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

import { Post } from './post.model';

@Injectable({ providedIn: 'root' })
export class PostsService {

  constructor(private http: HttpClient) { }

  createAndStorePost(title: string, content: string) {
    const postData: Post = { title: title, content: content };
    this.http
      .post<{ name: string }>(
        'https://recipe-book-2b037.firebaseio.com/posts.json',
        postData
      )
      .subscribe(responseData => {    // subscribe not moved
        console.log(responseData);
      });
  }

  fetchPosts() {
    return this.http
      .get<{ [key: string]: Post }>('https://recipe-book-2b037.firebaseio.com/posts.json')
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
        })
      );
    // .subscribe(posts => {    // subscribe  moved in tp the app.component.ts !!! therefore 'return' is added to enable this
    //   console.log(posts);
    //   // this.isFetching = false;
    //   // this.loadedPosts = posts;
    // });

  }

}
