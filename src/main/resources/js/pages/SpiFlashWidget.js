import { mapActions, mapState } from 'vuex'

export default {
    data: () => ({
        dialog: false,
    }),
    computed: {
        ...mapState({
            stored: state => state.global.stored,
        }),
    },
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
            await this.storeFlash();
        },
        async load() {
            await this.loadFlash();
        },
        async del() {
            await this.deleteFlash();
        },
    },
}