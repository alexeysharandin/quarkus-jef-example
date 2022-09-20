import { mapActions, mapState } from 'vuex'

export default {
    data: () => ({
        timer: '',
    }),
    computed: {
        ...mapState({
            pressure: state => state.global.pressure,
            temperature: state => state.global.temperature,
            altitude: state => state.global.altitude,
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
            load: 'global/loadBcm280'
        }),
        async fetchGps() {
            await this.load();
        },
    },
}