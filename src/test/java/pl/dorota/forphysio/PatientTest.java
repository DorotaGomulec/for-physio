package pl.dorota.forphysio;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();;
    private Patient patient;
    private String name;
    private int age;
    private Set<ConstraintViolation<Patient>> violations;

    @BeforeEach
    void beforeEach() {
        patient = new Patient();
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


}