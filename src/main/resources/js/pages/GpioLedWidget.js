export default {
    data: () => ({
        loading: false,
        selection: 1,
    }),
    methods: {
        on() {
            console.log("on");
        },
        off() {
            console.log("off");
        }
    },
}