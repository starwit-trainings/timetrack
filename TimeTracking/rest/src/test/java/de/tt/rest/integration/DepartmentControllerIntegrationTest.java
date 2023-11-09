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

import de.tt.persistence.entity.DepartmentEntity;
import de.tt.rest.controller.DepartmentController;
import de.tt.service.impl.DepartmentService;

/**
 * Tests for DepartmentController
 *
 * <pre>
 * @WebMvcTest also auto-configures MockMvc which offers a powerful way of
 * easy testing MVC controllers without starting a full HTTP server.
 * </pre>
 */
@WebMvcTest(controllers = DepartmentController.class)
public class DepartmentControllerIntegrationTest extends AbstractControllerIntegrationTest<DepartmentEntity> {

    @MockBean
    private DepartmentService departmentService;

    private JacksonTester<DepartmentEntity> jsonDepartmentEntity;
    private static final String data = "testdata/department/";
    private static final String restpath = "/api/departments/";

    @Override
    public Class<DepartmentEntity> getEntityClass() {
        return DepartmentEntity.class;
    }

    @Override
    public String getRestPath() {
        return restpath;
    }

    //implement tests here
    @Test
    public void canRetrieveById() throws Exception {

//        DepartmentEntity entityToTest = readFromFile(data + "department.json");
//        when(appService.findById(0L)).thenReturn(entityToTest);

//        MockHttpServletResponse response = retrieveById(0L);

        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        assertThat(response.getContentAsString())
//                .isEqualTo(jsonAppDto.write(dto).getJson());
    }

}
