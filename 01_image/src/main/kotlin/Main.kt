import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun main(args: Array<String>) {
    //内存中创建一个100*100的图片
    var image = BufferedImage(100,100,BufferedImage.TYPE_INT_RGB)
    var w = 0 .. 99
    var h = 0 .. 99
    //图片颜色设置为红色
    image.apply {
        for (i in w) {
            for (j in h) {
                this.setRGB(i, j, 0x0000ff)
            }
        }
    }
    ImageIO.write(image,"bmp", File("a.bmp"))
}