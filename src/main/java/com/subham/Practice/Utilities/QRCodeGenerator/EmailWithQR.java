package com.subham.Practice.Utilities.QRCodeGenerator;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import javax.activation.DataHandler;
import javax.imageio.ImageIO;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class EmailWithQR {

    public static void main(String[] args) {
        // Replace these values with your email credentials
        String senderEmail = "subhamsamantaray047@gmail.com";
        String senderPassword = "BNghMjpxkvZgLDqp4C/BOOtfObFFoiJwSQ/HMKDHwoD8";
        String recipientEmail = "subhamsamantaray047@gmail.com";

        try {
            // Generate QR code content
            String qrCodeContent = "https://www.example.com"; // Replace with your desired content

            // Generate QR code image
            BufferedImage qrCodeImage = generateQRCodeImage(qrCodeContent);

            // Encode the image as a base64 string
            String base64Image = encodeImageToBase64(qrCodeImage, "png");

            // Send email with embedded QR code image
            sendEmailWithEmbeddedImage(senderEmail, senderPassword, recipientEmail, base64Image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage generateQRCodeImage(String qrCodeContent) {
        try {
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            BitMatrix bitMatrix = new MultiFormatWriter().encode(qrCodeContent, BarcodeFormat.QR_CODE, 200, 200, hints);

            BufferedImage qrCodeImage = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < 200; x++) {
                for (int y = 0; y < 200; y++) {
                    qrCodeImage.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
                }
            }

            return qrCodeImage;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String encodeImageToBase64(BufferedImage image, String format) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, format, baos);
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }

    private static void sendEmailWithEmbeddedImage(String senderEmail, String senderPassword, String recipientEmail, String base64Image) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(senderEmail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
        message.setSubject("QR Code Email");

        // HTML content with embedded image
        String htmlContent = "<html><body><p>Please scan the QR code:</p><img src='data:image/png;base64," + base64Image + "'/></body></html>";

        // Create a multipart message
        Multipart multipart = new MimeMultipart();

        // Create the HTML part
        BodyPart htmlBodyPart = new MimeBodyPart();
        htmlBodyPart.setContent(htmlContent, "text/html");
        multipart.addBodyPart(htmlBodyPart);

        // Attach the image
        BodyPart attachmentBodyPart = new MimeBodyPart();
        attachmentBodyPart.setDataHandler(new DataHandler(new ByteArrayDataSource(Base64.getDecoder().decode(base64Image), "image/png")));
        attachmentBodyPart.setFileName("qrcode.png");
        multipart.addBodyPart(attachmentBodyPart);

        // Set the content of the message
        message.setContent(multipart);

        // Send the message
        Transport.send(message);

        System.out.println("Email sent successfully!");
    }
}

