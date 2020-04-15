package org.academiadecodigo.apiores.quarentinos.services;

import org.academiadecodigo.apiores.quarentinos.persistence.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    private Integer id;
    private Map<Integer, Appointment> appointments;


    public AppointmentServiceImpl() {
        appointments = new HashMap<>();
        id=0;
    }

    @Override
    public Appointment get(Integer id) {
        return appointments.get(id);
    }

    @Override
    public List<Appointment> getAll() {
        return new ArrayList<>(appointments.values());
    }

    @Override
    public Appointment create(Appointment appointment) {
        id++;
        appointment.setId(id);
        appointments.put(id,appointment);
        return appointment;

    }

    @Override
    public Appointment update(Appointment appointment) {
        appointments.replace(appointment.getId(),appointment);
        return appointment;
    }

    @Override
    public void delete(Integer id) {
        appointments.remove(id);
    }
}
