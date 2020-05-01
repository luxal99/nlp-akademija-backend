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

    //region --SendMail--
    @Autowired
    private AdminService sendMailAdminService;

    @PostMapping("/sendMail")
    public ResponseEntity sendMail(@RequestBody MailDTO mailDTO) throws MessagingException, InterruptedException {
        return ResponseEntity.ok(sendMailAdminService.sendMail(mailDTO));
    }
    //endregion

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
