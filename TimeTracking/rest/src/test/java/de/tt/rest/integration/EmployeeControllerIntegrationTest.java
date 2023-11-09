package de.tt.rest.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;

import de.tt.persistence.entity.EmployeeEntity;
import de.tt.rest.controller.EmployeeController;
import de.tt.service.impl.EmployeeService;

/**
 * Tests for EmployeeController
 *
 * <pre>
 * @WebMvcTest also auto-configures MockMvc which offers a powerful way of
 * easy testing MVC controllers without starting a full HTTP server.
 * </pre>
 */
@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerIntegrationTest extends AbstractControllerIntegrationTest<EmployeeEntity> {

    @MockBean
    private EmployeeService employeeService;

    private JacksonTester<EmployeeEntity> jsonEmployeeEntity;
    private static final String data = "testdata/employee/";
    private static final String restpath = "/api/employees/";

    @Override
    public Class<EmployeeEntity> getEntityClass() {
        return EmployeeEntity.class;
    }

    @Override
    public String getRestPath() {
        return restpath;
    }

    //implement tests here
    @Test
    public void canRetrieveById() throws Exception {

//        EmployeeEntity entityToTest = readFromFile(data + "employee.json");
//        when(appService.findById(0L)).thenReturn(entityToTest);

//        MockHttpServletResponse response = retrieveById(0L);

        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        assertThat(response.getContentAsString())
//                .isEqualTo(jsonAppDto.write(dto).getJson());
    }

}
