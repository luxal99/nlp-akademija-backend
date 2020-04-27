package com.example.demo.controller;


import com.example.demo.dto.MailDTO;
import com.example.demo.entity.*;
import com.example.demo.repository.ImageRepository;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@CrossOrigin(value = "https://157.230.25.201:8443")
@RestController
@RequestMapping("/admin")
public class AdminController {

    //region --Event --
    @Autowired
    private EventService eventService;

    @GetMapping("event/getAllEvents")
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAll());
    }

    @PostMapping("event/saveEvent")
    public ResponseEntity saveEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.save(event));
    }

    @DeleteMapping("event/deleteEvent/{id}")
    public ResponseEntity deleteEvent(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.delete(id));
    }

    @PutMapping("event/updateEvent")
    public ResponseEntity updateEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.update(event));

    }


    //endregion

    //region -- Product --

    @Autowired
    private ProductService productService;

    @PostMapping("product/saveProduct")
    public ResponseEntity saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping("product/getAllProduct")
    public ResponseEntity getAllProduct() {
        return ResponseEntity.ok(productService.getALL());
    }

    @DeleteMapping("product/deleteProduct/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.delete(id));
    }

    @PutMapping("product/updateProduct")
    public ResponseEntity updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.update(product));
    }

    //endregion

    //region -- Client --
    @Autowired
    private ClientService clientService;

    @PostMapping("client/saveClient")
    public ResponseEntity saveClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.save(client));
    }

    @GetMapping("client/getAllClients")
    public ResponseEntity getAllClients() {
        return ResponseEntity.ok(clientService.getAll());
    }
    //endregion

    //region -- Comment --
    @Autowired
    private CommentService commentService;

    @PostMapping("comment/saveComment")
    public ResponseEntity saveComment(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.saveComment(comment));
    }

    @GetMapping("comment/getAllComments")
    public ResponseEntity getAllComments() {
        return ResponseEntity.ok(commentService.getAllComments());
    }

    @DeleteMapping("comments/deleteComment/{id}")
    public ResponseEntity deleteComment(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.delete(id));
    }
    //endregion

    //region -- CourseCheckin --

    @Autowired
    private CourseCheckinService courseCheckinService;

    @PostMapping("courseCheckin/saveCourseCheckin")
    public ResponseEntity saveCourseCheckin(@RequestBody CourseCheckin courseCheckin) {
        return ResponseEntity.ok(courseCheckinService.save(courseCheckin));

    }

    @GetMapping("courseCheckin/getAllCourseCheckin")
    public ResponseEntity getAllCourseCheckin() {
        return ResponseEntity.ok(courseCheckinService.getAll());
    }


    //endregion

    //region --OnlineCheckIn --

    @Autowired
    private OnlineCheckInService onlineCheckInService;

    @PostMapping("checkin/saveCheckIn")
    public ResponseEntity saveCheckIn(@RequestBody OnlineCheckIn onlineCheckIn) {
        return ResponseEntity.ok(onlineCheckInService.save(onlineCheckIn));
    }

    @GetMapping("checkin/getAll")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(onlineCheckInService.getAll());
    }

    //endregion

    //region --Login--
    @Autowired
    private AdminService adminService;

    @GetMapping("/isLoginValid/{username}/{password}")
    public ResponseEntity isValid(@PathVariable String username, @PathVariable String password) {
        return ResponseEntity.ok(adminService.isValid(username, password));
    }

    @PutMapping("/loginFlag")
    public ResponseEntity setFlag(@RequestBody Admin admin) {
        return ResponseEntity.ok(adminService.putFlag(admin));
    }

    @GetMapping("/isLogged")
    public ResponseEntity isLogged() {
        return ResponseEntity.ok(adminService.isLogged());
    }

    @GetMapping("/getAdmin")
    public ResponseEntity getAdmin() {
        return ResponseEntity.ok(adminService.getAdmin());
    }
    //endregion

    //region -- OnlinePurchase --

    @Autowired
    private OnlinePurchaseService onlinePurchaseService;

    @PostMapping("/onlinePurchase/savePurchase/{listOfSelectedProduct}")
    public ResponseEntity savePurchase(@PathVariable Long[] listOfSelectedProduct, @RequestBody OnlinePurchase onlinePurchase) throws InterruptedException {

        return ResponseEntity.ok(onlinePurchaseService.save(onlinePurchase, listOfSelectedProduct));

    }

    @GetMapping("onlinePurchase/getAll")
    public ResponseEntity getAllPurchase() {
        return ResponseEntity.ok(onlinePurchaseService.getAll());
    }
    //endregion

    //region -- Training --

    @Autowired
    private OnlineTrainingCheckinService onlineTrainingCheckinService;

    @PostMapping("onlineTraining/saveOnlineTraining")
    public ResponseEntity saveOnlineTraining(@RequestBody OnlineTrainingCheckin onlineTrainingCheckin) {
        return ResponseEntity.ok(onlineTrainingCheckinService.save(onlineTrainingCheckin));
    }

    @GetMapping("/onlineTraining/getAllOnlineTraining")
    public ResponseEntity<List<OnlineTrainingCheckin>> getAllTrraining() {
        return ResponseEntity.ok(onlineTrainingCheckinService.getAll());
    }

    @DeleteMapping("/onlineTraining/deleteOnlineTraining/{idOnlineTraining}")
    public ResponseEntity deleteOnlineTraining(@PathVariable Long idOnlineTraining) {
        return ResponseEntity.ok(onlineTrainingCheckinService.deleteTrainingCheckin(idOnlineTraining));
    }

    @PostMapping("client/search")
    public ResponseEntity<List<OnlineTrainingCheckin>> searchClient(@RequestBody Date date) {
        System.out.println(date.toString());
        return ResponseEntity.ok(onlineTrainingCheckinService.findClienByDate(date));
    }

    //endregion

    //region --SendMail--
    @Autowired
    private AdminService sendMailAdminService;

    @PostMapping("/sendMail")
    public ResponseEntity sendMail(@RequestBody MailDTO mailDTO) throws MessagingException, InterruptedException {
        return ResponseEntity.ok(sendMailAdminService.sendMail(mailDTO));
    }
    //endregion

    @GetMapping("/getProductById/{id}")
    public ResponseEntity getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity.BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        return imageService.uploadImage(imageFile);

    }

    public static byte[] compressBytes(byte[] data) {

        Deflater deflater = new Deflater();

        deflater.setInput(data);

        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

        byte[] buffer = new byte[1024];

        while (!deflater.finished()) {

            int count = deflater.deflate(buffer);

            outputStream.write(buffer, 0, count);

        }

        try {

            outputStream.close();

        } catch (IOException e) {

        }

        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        return outputStream.toByteArray();

    }

    @GetMapping(path = {"/get/{imageName}"})

    public ImageTable getImage(@PathVariable("imageName") String imageName) throws IOException {
        return imageService.getImage(imageName);
    }


}
