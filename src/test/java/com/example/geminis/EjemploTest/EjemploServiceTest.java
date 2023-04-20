package com.example.geminis.EjemploTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.geminis.GeminisApplication;
import com.example.geminis.dto.EjemploDTO;
import com.example.geminis.service.EjemploService;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import javax.inject.Inject;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GeminisApplication.class)
@DatabaseSetup(value = {"/datasets/ejemplo.xml"})
@DatabaseTearDown(value = {"/datasets/ejemplo.xml"}, type = DatabaseOperation.DELETE_ALL)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
public class EjemploServiceTest extends BaseEjemploTest {

    @Inject
    private EjemploService ejemploService;

    @Test
    public void testEjemploCreacionTest() {

        //Arrange
        EjemploDTO ejemploDTO1 = construir();

        //Act
        EjemploDTO ejemploDTO = ejemploService.crear(ejemploDTO1);

        //Assert
        assertThat(ejemploDTO).isNotNull();
    }

    @Test
    public void revisarNameTest() {

        //Arrange
        EjemploDTO ejemploDTO1 = construir();

        //Act
        EjemploDTO ejemploDTO = ejemploService.crearOtro(ejemploDTO1);

        //Assert
        assertThat(ejemploDTO.getName().equals(ejemploDTO1.getName())).isTrue();
    }
}
