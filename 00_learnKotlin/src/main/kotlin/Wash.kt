//洗衣服
fun main(args:Array<String>) {
    var washMachine = WashMachine("小天鹅", 12)
    washMachine.openDoor()
    washMachine.closeDoor()
    washMachine.setMode(2)
    washMachine.start()
}