import javafx.application.Application
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.paint.Color
import org.itheima.kotlin.game.core.Composer
import org.itheima.kotlin.game.core.Painter
import org.itheima.kotlin.game.core.Window
import java.nio.file.Paths

//创建窗体
class MyWindow:Window() {
    override fun onCreate() {
        println("窗体创建")
    }

    override fun onDisplay() {
        //当前路径
//        var path = Paths.get("").toAbsolutePath().toString()
//        println(path)
        //不停地被执行，窗体渲染时的回调
//        println("窗体显示")
        //绘制图片
        Painter.drawImage("essentials-01.png", 150, 200)
        //绘制颜色
        Painter.drawColor(Color.WHITE, 20, 20, 70, 100)
        //绘制文字
        Painter.drawText("你好啊", 30, 30)
    }

    override fun onKeyPressed(event: KeyEvent) {
        //按键响应
        when(event.code) {
            KeyCode.ENTER -> println("回车")
            KeyCode.P -> Composer.play("qiang sheng.wav")
        }
    }

    override fun onRefresh() {
        //刷新事件，做业务逻辑，比较耗时的操作
    }
}

fun main(args: Array<String>) {
    //游戏启动
    Application.launch(MyWindow::class.java)
}