import { mapActions, mapState } from 'vuex'

export default {
    data: () => ({
        value: '',
        timer: '',
    }),
    computed: {
        ...mapState({
            lux: state => state.global.lux,
        }),
    },
    created() {
        this.timer = window.setInterval(this.fetchLight, 1000);
    },
    beforeUnmount () {
          clearInterval(this.timer);
    },
    methods: {
        ...mapActions({
            load: 'global/loadLux'
        }),
        async fetchLight() {
            await this.load();
        },
    },
}