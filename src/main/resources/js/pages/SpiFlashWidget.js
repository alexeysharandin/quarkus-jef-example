import { mapActions, mapState } from 'vuex'

export default {
    data: () => ({
        loading: false,
        value: 0,
        timer: '',
        selection: 1,
    }),
    created() {
        this.timer = window.setInterval(this.fetchGps, 1000);
    },
    beforeUnmount () {
          clearInterval(this.timer);
    },
    methods: {
        ...mapActions({
            loadFlash: 'global/loadData',
            storeFlash: 'global/storeData',
            deleteFlash: 'global/deleteData',
        }),
        fetchGps() {
            this.value += 1;
        },
        async save() {
            await this.loadFlash();
        },
        async load() {
            await this.storeFlash();
        },
        async del() {
            await this.deleteFlash();
        }
    },
}