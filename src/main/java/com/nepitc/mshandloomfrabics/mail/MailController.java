/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.mail;

import com.nepitc.mshandloomfrabics.entity.GetInTouch;
import com.nepitc.mshandloomfrabics.entity.OrderModel;
import com.nepitc.mshandloomfrabics.service.OrderService;
import com.nepitc.mshandloomfrabics.service.UserService;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Nishan Dhungana
 */
@Controller
public class MailController {

    private final String emailSubject = "Recover Password";
    private final String emailFromRecipient = "nishandhungana41@gmail.com";

    @Autowired
    private JavaMailSender mailSenderObj;

    @Autowired
    private UserService userService;
    
    @Autowired
    private OrderService orderService;
    
    @RequestMapping(value = "/mail/send-mail", method = RequestMethod.POST, produces="application/x-www-form-urlencoded")
    public ResponseEntity<String> sendEmailToClient(@RequestBody final String email) {
        final StringBuilder message = new StringBuilder();
        String userName = userService.getUsername(email);
        message.append("<p>Please click <a href=\"http://localhost:4200/admin/change-password?username=").append(userName).append("\">here</a> to recover password</p>");

        try {
            mailSenderObj.send(new MimeMessagePreparator() {
                @Override
                public void prepare(MimeMessage mimeMessage) throws Exception {
                    MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                    mimeMsgHelperObj.setTo(email);
                    mimeMsgHelperObj.setFrom(emailFromRecipient);
                    mimeMsgHelperObj.setText(message.toString(), true);
                    mimeMsgHelperObj.setSubject(emailSubject);
                }
            });

            return new ResponseEntity(HttpStatus.OK);
        } catch (MailException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/admin-api/confirm-order/{orderId}", method = RequestMethod.GET)
    public ResponseEntity<String> confirmOrder(@PathVariable("orderId") int orderId) {
        final StringBuilder message = new StringBuilder();
        
        OrderModel orderModel = orderService.getById(orderId);
        final String email = orderModel.getUserId().getEmail();
        final String productName = orderModel.getPashminaId().getPashminaName();
        final String shippingAddress = orderModel.getShippingAddress();
        final String category = orderModel.getPashminaId().getCategory();
        final int quantity = orderModel.getQuantity();
        final double price = orderModel.getPashminaId().getPrice();
        final double totalPrice = quantity * price;
        
        
        
        message.append("<h2>Product name: ").append(productName).append("</h2><br><hr>\n" +
"		<center>\n" +
"			<b>Success - Your order has been confirmed</b>\n" +
"		</center>\n" +
"		\n" +
"		<p>Shipping Address: ").append(shippingAddress).append("</p>\n" +
"		<hr>\n" +
"		<table width=\"100%\">\n" +
"			<tr>\n" +
"				<td>Product</td>\n" +
"				<td>Category</td>\n" +
"				<td>Quantity</td>\n" +
"				<td>Price</td>\n" +
"			</tr>\n" +
"			<tr>\n" +
"				<td>").append(productName).append("</td>\n" +
"				<td>").append(category).append("</td>\n" +
"				<td>").append(quantity).append("</td>\n" +
"				<td>Rs. ").append(price).append("</td>\n" +
"			</tr>\n" +
"		</table><hr>\n" +
"		<p align=\"right\">Total: Rs. ").append(totalPrice).append("</p><br><br>\n" +
"		<p>Thank you for trusting us............</p>\n" +
"		<p>M.S. HandLoom Fabrics</p>\n" +
"		<p>Contact: +91 - 9205756240</p>\n" +
"		<p>Email: info@mshandloomfabrics.com</p>");

        try {
            mailSenderObj.send(new MimeMessagePreparator() {
                @Override
                public void prepare(MimeMessage mimeMessage) throws Exception {
                    MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                    mimeMsgHelperObj.setTo(email);
                    mimeMsgHelperObj.setFrom(emailFromRecipient);
                    mimeMsgHelperObj.setText(message.toString(), true);
                    mimeMsgHelperObj.setSubject("You order has been confirmed");
                }
            });
            
            orderService.updateOrderStatus(orderId);
            return new ResponseEntity(HttpStatus.OK);
        } catch (MailException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/mail/get-in-touch", method = RequestMethod.POST, produces="application/x-www-form-urlencoded")
    public ResponseEntity<String> getInTouch(@RequestBody final GetInTouch temp) {
        //final StringBuilder message = new StringBuilder();
        //String userName = userService.getUsername(email);
        //message.append("<p>Please click <a href=\"http://localhost:4200/admin/change-password?username=").append(userName).append("\">here</a> to recover password</p>");

        try {
            mailSenderObj.send(new MimeMessagePreparator() {
                @Override
                public void prepare(MimeMessage mimeMessage) throws Exception {
                    MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                    mimeMsgHelperObj.setTo("nishandhungana41@gmail.com");
                    mimeMsgHelperObj.setFrom(temp.getEmail());
                    mimeMsgHelperObj.setText(temp.getBody(), true);
                    mimeMsgHelperObj.setSubject(temp.getSubject());
                }
            });

            return new ResponseEntity(HttpStatus.OK);
        } catch (MailException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
}
