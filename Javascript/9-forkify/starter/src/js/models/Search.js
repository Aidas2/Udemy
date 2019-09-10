import axios from 'axios';

export default class Search {
    constructor(query) {
        this.query = query;
    }

    async getResult() {
        const key = '9cf1ece1da7608ad4a540b6a0ccf358b'
        try {
            const res = await axios(`https://www.food2fork.com/api/search?key=${key}&q=${this.query}`);
            // console.log(res);
            this.result = res.data.recipes;
            // console.log(this.result);
        } catch (error) {
            alert(error)
        }

    }

}