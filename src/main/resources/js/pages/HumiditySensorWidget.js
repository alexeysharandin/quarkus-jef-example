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
        fetchGps() {
            this.value += 1;
        },
    },
}