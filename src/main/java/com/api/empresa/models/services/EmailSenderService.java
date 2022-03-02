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
        mailMessage.setSubject("Entrega Creada!");
        mailMessage.setFrom("nairobley@gmail.com");
        mailMessage.setText("En hora buena, has creado una nueva entrega! \n "
                +"** Detalles **\n "+ "Nombre proyecto: "+ projectDelivery.getProjectName()+
                "\n Fecha entrega: "+projectDelivery.getDeliveryDate()+
                "\n Hora de entrega: " + projectDelivery.getDeliveryHour()+
                "\n Lugar/Medio de entrega: "+projectDelivery.getDeliveryPlace());

        this.javaMailSender.send(mailMessage);
    }

    public void sendRequirementMail(Requirement requirement) {
        // Create the email for send
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(requirement.getRequerement_usermail());
        mailMessage.setSubject("Requerimiento Creado!");
        mailMessage.setFrom("nairobley@gmail.com");
        mailMessage.setText("En hora buena, has creado un nuevo requerimiento! \n "
                +"** Detalles **\n "+
                "\n Nombre del proyecto: "+requirement.getProjectName() +
                "\n Titulo del requerimiento: "+ requirement.getRequirementTitle()+
                "\n Prioridad del requerimiento: " + requirement.getRequirementPriority()+
                "\n Descripción: "+requirement.getRequirementDescription());
        this.javaMailSender.send(mailMessage);
    }

    public void sendProjectMail(Project project) {
        // Create the email for send
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(project.getClientEmail());
        mailMessage.setSubject("Proyecto Creado!");
        mailMessage.setFrom("nairobley@gmail.com");
        mailMessage.setText("En hora buena, has creado un nuevo proyecto. Gracias por confiar en nosotros! \n"
                +"** Detalles **\n"+
                "Nombre proyecto: "+ project.getProjectName()+
                "\n Tipo de Servicio: "+ project.getServiceType()+
                "\n Descripción: " + project.getProjectDescription()+
                "\n Fecha inicio: "+project.getStartDate() +
                "\n Fecha estimada de finalización: "+project.getEndDate()+
                ""+ project.getRequirements());
        this.javaMailSender.send(mailMessage);
    }
}
