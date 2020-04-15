package org.academiadecodigo.apiores.quarentinos.services;

import org.academiadecodigo.apiores.quarentinos.persistence.model.Appointment;
import java.util.List;

public interface AppointmentService {
    Appointment get(Integer id);

    List<Appointment> getAll();

    Appointment create(Appointment appointment);

    void delete(Integer id);

    Appointment update(Appointment appointment);

}
