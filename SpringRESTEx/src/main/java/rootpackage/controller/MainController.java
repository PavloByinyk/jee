package rootpackage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rootpackage.entity.MyDataObject;

import java.util.Calendar;

@Controller
// мапим наш REST на /myservice
@RequestMapping(value = "/myservice")
public class MainController {

    // этот метод будет принимать время методом GET и на его основе
    // отвечать клиенту
    @RequestMapping(value= "/{time}", method = RequestMethod.GET)
    @ResponseBody
    public MyDataObject getMyData(@PathVariable("time") long time) {
        return new MyDataObject(Calendar.getInstance(), "Это ответ метода GET!");
    }

    // этот метод будет принимать Объект MyDataObject и отдавать его клиенту
    // обычно метод PUT используют для сохранения либо для обновления объекта
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public MyDataObject putMyData(@RequestBody MyDataObject md) {
        return md;
    }

    // этот метод будет методом POST отдавать объект MyDataObject
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public MyDataObject postMyData() {
        return new MyDataObject(Calendar.getInstance(), "это ответ метода POST!");
    }

    // этот метод будет принимать время методом DELETE
    // и на его основе можно удалит объект
    @RequestMapping(value= "/{time}", method = RequestMethod.DELETE)
    @ResponseBody
    public MyDataObject deleteMyData(@PathVariable long time) {
        return new MyDataObject(Calendar.getInstance(), "Это ответ метода DELETE!");
    }

}
