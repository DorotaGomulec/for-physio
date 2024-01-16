package pl.dorota.forphysio.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.dorota.forphysio.Gender;
import pl.dorota.forphysio.dto.PatientDTO;
import pl.dorota.forphysio.dto.UpdatePatientDTO;
import pl.dorota.forphysio.InjuryTypeEnum;

class PatientControllerTest {

    PatientDTO patientToUpdate;

    @BeforeEach
    void before(){
        patientToUpdate = createMock( 1,"Adam Kowalski",30, Gender.MALE, "509 509 509", InjuryTypeEnum.MUSCLES,true );
    }

    @Test
    void updatePatient_updatingPhoneNumber_resultUpdatedOK() {

        UpdatePatientDTO updatedPatient = new UpdatePatientDTO("Adam Kowalski", 30, null, "888 888 888", null, null);

        if (!updatedPatient.getName().isBlank()) patientToUpdate.setName( updatedPatient.getName() );
        if (updatedPatient.getAge() >= 0) patientToUpdate.setAge( updatedPatient.getAge() );
        if (updatedPatient.getGender() != null) patientToUpdate.setGender( updatedPatient.getGender() );
        if (updatedPatient.getInjuryType() != null) patientToUpdate.setInjuryType( updatedPatient.getInjuryType() );
        if (updatedPatient.getPhoneNumber() != null) patientToUpdate.setPhoneNumber( updatedPatient.getPhoneNumber() );
        if (updatedPatient.getHasInsurance() != null)
            patientToUpdate.setHasInsurance( updatedPatient.getHasInsurance() );

        Assertions.assertEquals( Gender.MALE ,  patientToUpdate.getGender() );

    }

    @Test
    void updatePatient_updateNameToBlankValue_nameStayTheSameOK() {

        UpdatePatientDTO updatedPatient = new UpdatePatientDTO(" ", 30, null, "888 888 888", null, null);

        if (!updatedPatient.getName().isBlank()) patientToUpdate.setName( updatedPatient.getName() );
        if (updatedPatient.getAge() >= 0) patientToUpdate.setAge( updatedPatient.getAge() );
        if (updatedPatient.getGender() != null) patientToUpdate.setGender( updatedPatient.getGender() );
        if (updatedPatient.getInjuryType() != null) patientToUpdate.setInjuryType( updatedPatient.getInjuryType() );
        if (updatedPatient.getPhoneNumber() != null) patientToUpdate.setPhoneNumber( updatedPatient.getPhoneNumber() );
        if (updatedPatient.getHasInsurance() != null)
            patientToUpdate.setHasInsurance( updatedPatient.getHasInsurance() );

        Assertions.assertEquals( "Adam Kowalski" ,  patientToUpdate.getName() );

    }

    private PatientDTO createMock(int id, String name, Integer age, Gender gender, String phoneNumber,
                                  InjuryTypeEnum injuryType, Boolean hasInsurance) {

        PatientDTO mockPatientDTO = Mockito.mock( PatientDTO.class );
        Mockito.when( mockPatientDTO.getId() ).thenReturn( id );
        Mockito.when( mockPatientDTO.getName() ).thenReturn( name );
        Mockito.when( mockPatientDTO.getGender() ).thenReturn( gender );
        Mockito.when( mockPatientDTO.getPhoneNumber() ).thenReturn( phoneNumber );
        Mockito.when( mockPatientDTO.getInjuryType() ).thenReturn( injuryType );
        Mockito.when( mockPatientDTO.getHasInsurance() ).thenReturn( hasInsurance );
        return mockPatientDTO;
    }

}