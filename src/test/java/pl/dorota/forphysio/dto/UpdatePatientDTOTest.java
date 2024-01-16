package pl.dorota.forphysio.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.dorota.forphysio.dto.UpdatePatientDTO;

import java.util.Set;

class UpdatePatientDTOTest{
    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();;
    private UpdatePatientDTO patient;
    private String name;
    private int age;
    private String phoneNumber;
    private Set<ConstraintViolation<UpdatePatientDTO>> violations;

    @BeforeEach
    void beforeEach() {
        patient = new UpdatePatientDTO();
    }

    @Test
    void setName_notBlankName_noConstraintViolation() {

        name = "David";
        patient.setName( name );

        violations = validator.validate(patient);

        Assert.assertEquals( 0, violations.size() );
    }

    @Test
    void setName_blankName_ConstraintViolation() {

        name = " ";
        patient.setName( name );

        violations = validator.validate( patient );

        Assert.assertEquals( 1, violations.size() );
    }

    @Test
    void setAge_paramsOk_noConstraintViolation(){
        age = 0;
        patient.setName( "David" );
        patient.setAge( age );

        violations = validator.validate( patient );

        Assert.assertEquals( 0,violations.size() );
    }

    @Test
    void setAge_ageBelowZero_ConstraintViolation(){
        age = -1;
        patient.setName( "David" );
        patient.setAge( age );

        violations = validator.validate( patient );

        Assert.assertEquals( 1, violations.size() );

    }

    @Test
    void setPhoneNumber_paramsOk_noConstraintViolation(){
        phoneNumber = "222333444";
        patient.setPhoneNumber(phoneNumber );
        patient.setName( "David" );
        violations = validator.validate(patient);

        Assert.assertEquals( 0,violations.size() );

    }

    @Test
    void setPhoneNumber_phoneNumbSizeBelowLimit_ConstraintViolation(){
        phoneNumber = "123";
        patient.setPhoneNumber( phoneNumber );
        patient.setName( "David" );

        violations = validator.validate(patient);

        Assert.assertEquals( 1,violations.size() );

    }

    @Test
    void setPhoneNumber_phoneNumbSizeOverLimit_ConstraintViolation(){
        phoneNumber = "123 123 123 1231";
        patient.setPhoneNumber( phoneNumber );
        patient.setName( "David" );

        violations = validator.validate(patient);

        Assert.assertEquals( 1,violations.size() );

    }




}
