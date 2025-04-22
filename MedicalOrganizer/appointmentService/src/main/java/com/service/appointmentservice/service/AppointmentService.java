package com.service.appointmentservice.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.service.appointmentservice.entity.Appointment;
import com.service.appointmentservice.repository.AppointmentRepository;

@Service
public class AppointmentService {
    
    private AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }

    public void createAppointment(Appointment appointment){
        ArrayList<Appointment> appointmentsAll = appointmentRepository.findAll();
        for (Appointment appointmentList : appointmentsAll){
            if (appointmentList.getDate().equals(appointment.getDate()) && appointmentList.getDoctor().equals(appointment.getDoctor())){
                throw(new RuntimeException("You can't have two appointments on the same day with the same doctor. Please try again."));
            }
        }
        appointmentRepository.save(appointment);
    }

    public Optional<ArrayList<Appointment>> getAllAppointments(){
        ArrayList<Appointment> appointmentsAll = appointmentRepository.findAll();
        return appointmentsAll.isEmpty() ? Optional.empty() : Optional.of(appointmentsAll);
    }
}




// ArrayList<ExerciseRecord> recordsAll = recordRepository.findAll();
// for (ExerciseRecord record : recordsAll){
//     if (record.getActivity().equals(exerciseRecord.getActivity()) && record.getDate().equals(exerciseRecord.getDate()) && record.getDuration() == exerciseRecord.getDuration()){
//         throw(new RuntimeException("You cannot duplicate a daily record with the same date, activity, and duration."));
//     }
// }
// recordRepository.save(exerciseRecord);