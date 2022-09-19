export default {
    data: () => ({
        loading: false,
        value: 0,
        timer: '',
        selection: 1,
    }),
    created() {
        this.timer = window.setInterval(this.fetchLight, 1000);
    },
    beforeUnmount () {
          clearInterval(this.timer);
    },
    methods: {
        fetchLight() {
            this.value += 1;
        },
    },
}