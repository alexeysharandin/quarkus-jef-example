//import MainMenu from './MainMenu.vue'
import AmbientLight from './AmbientLightWidget.vue'
import GpioLed from './GpioLedWidget.vue'
import Gps from './GpsWidget.vue'
import HumiditySensor from './HumiditySensorWidget.vue'
import SpiFlash from './SpiFlashWidget.vue'

export default {
    name: "ConsoleApp",
    components: {AmbientLight, GpioLed, Gps, HumiditySensor, SpiFlash},
    data: () => ({
    }),
}