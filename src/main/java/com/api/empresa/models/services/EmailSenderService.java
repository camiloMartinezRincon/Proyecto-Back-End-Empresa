package com.api.empresa.models.services;

import com.api.empresa.models.entity.Project;
import com.api.empresa.models.entity.ProjectDelivery;
import com.api.empresa.models.entity.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendProjectDeliveryMail(ProjectDelivery projectDelivery) {
        // Create the email for send
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(projectDelivery.getClientEmail());
        mailMessage.setSubject("Proyecto Creado!");
        mailMessage.setFrom("nairobley@gmail.com");
        mailMessage.setText("En hora buena, has creado el proyecto exitosamente! "
                +"Detalles "+ "Nombre proyecto: "+ projectDelivery.getProjectName()+
                "Fecha entrega: "+projectDelivery.getDeliveryDate()+
                "Hora de entrega" + projectDelivery.getDeliveryHour()+
                "Lugar/Medio de entrega"+projectDelivery.getDeliveryPlace());

        this.javaMailSender.send(mailMessage);
    }

    public void sendRequirementMail(Requirement requirement) {
        // Create the email for send
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("Proyecto Creado!");
        mailMessage.setFrom("nairobley@gmail.com");
        mailMessage.setText("En hora buena, se ha creado un nuevo requerimiento "
                +"Detalles "+ "Titulo del requerimiento: "+ requirement.getRequirementTitle()+
                "Prioridad del requerimiento: " + requirement.getRequirementPriority()+
                "Descripción: "+requirement.getRequirementDescription() +
                "Nombre del proyecto: "+requirement.getProjectName());
        this.javaMailSender.send(mailMessage);
    }

    public void sendProjectMail(Project project) {
        // Create the email for send
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(project.getClientEmail());
        mailMessage.setSubject("Proyecto Creado!");
        mailMessage.setFrom("nairobley@gmail.com");
        mailMessage.setText("En hora buena, se ha creado un nuevo requerimiento "
                +"Detalles "+ "Titulo del requerimiento: "+ project.getProjectName()+
                "Prioridad del requerimiento: " + project.getProjectDescription()+
                "Descripción: "+project.getStartDate() +
                "Nombre del proyecto: "+project.getEndDate()+
                ""+ project.getRequirements());
        this.javaMailSender.send(mailMessage);
    }

}
