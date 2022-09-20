import { mapActions, mapState } from 'vuex'

export default {
    data: () => ({
        timer: '',
    }),
    computed: {
        ...mapState({
            longitude: state => state.global.longitude,
            latitude: state => state.global.latitude,
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
            load: 'global/loadGps'
        }),
        async fetchGps() {
            await this.load();
        },
    },
}