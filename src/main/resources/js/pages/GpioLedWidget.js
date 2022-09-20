import { mapActions } from 'vuex'

export default {
    data: () => ({
        status: false,
    }),
    methods: {
        ...mapActions({
            change: 'global/updateGpio'
        }),
        async on() {
            await this.change(true);
            this.status = true;
        },
        async off() {
            await this.change(false);
            this.status = false;
        }
    },
}