import axios from 'axios'

let base="http://127.0.0.1:8081"

export const postRequest = (url, params) => {
    return axios({
        method: 'post',
        url: `${base}${url}`,
        data: params,
        // transformRequest: [function (data) {
        // let ret = ''
        // for (let it in data) {
        //     ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
        // }
        // return ret
        // }],
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
            
        }
    });
}

export const getRequest = (url, params) => {
    return axios({
        method: 'get',
        url: `${base}${url}`,
        data: params,
        // transformRequest: [function (data) {
        // let ret = ''
        // for (let it in data) {
        //     ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
        // }
        // return ret
        // }],
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
            
        }
    });
}