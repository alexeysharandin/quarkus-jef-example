import Vue from 'vue'

Vue.axios.defaults.headers.common['Cache-Control'] = "no-cache, no-store, must-revalidate";
Vue.axios.defaults.headers.common['Pragma'] = "no-cache";
Vue.axios.defaults.headers.common['Expires'] = "0";

export default {
    light: () => Vue.axios.get('/api/v1/light'),
    gpio: (data) => Vue.axios.get(`/api/v1/gpio/${data}`),
    gps: () => Vue.axios.get('/api/v1/gps'),
    bmp280: () => Vue.axios.get('/api/v1/bmp280'),
    store: (data) => Vue.axios.post('/api/v1/flash', data),
    load:() => Vue.axios.get('/api/v1/flash'),
    delete:() => Vue.axios.delete('/api/v1/flash'),
}