package de.tt.rest.acceptance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;

import de.tt.persistence.entity.TimeTrackEntity;

@SpringBootTest
@EnableAutoConfiguration
@AutoConfigureMockMvc(addFilters = false)
public class TimeTrackControllerAcceptanceTest extends AbstractControllerAcceptanceTest<TimeTrackEntity> {


    final static Logger LOG = LoggerFactory.getLogger(TimeTrackControllerAcceptanceTest.class);
    private static final String data = "testdata/timetrack/";
    private static final String restpath = "/api/timetracks/";

    private JacksonTester<TimeTrackEntity> jsonTester;

    @Override
    public Class<TimeTrackEntity> getEntityClass() {
        return TimeTrackEntity.class;
    }

    @Override
    public String getRestPath() {
        return restpath;
    }

    @Override
    public JacksonTester<TimeTrackEntity> getJsonTester() {
        return jsonTester;
    }

    @Test
    public void canCreate() throws Exception {
        // given
//        TimeTrackEntity entity = readFromFile(data + "TimeTrack.json");
  
        // when
//        MockHttpServletResponse response = create(entity);

        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        TimeTrackEntity entityresult = mapper.readValue(response.getContentAsString(), TimeTrackEntity.class);
//        assertThat(entityresult.getBranch()).isEqualTo("v2");
    }

    @Test
    public void isValidated() throws Exception {
        // given
//        TimeTrackEntity entity = readFromFile(data + "TimeTrack-wrong.json");
  
        // when
//        MockHttpServletResponse response = create(entity);

        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void canNotFindById() throws Exception {
        // when
        MockHttpServletResponse response = mvc
                .perform(get(getRestPath() + "/4242").contentType(MediaType.APPLICATION_JSON)).andReturn()
                .getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void canRetrieveById() throws Exception {
        // given
//        TimeTrackEntity entity = readFromFile(data + "TimeTrack.json");
//        MockHttpServletResponse response = create(entity);
//        TimeTrackEntity entity2 = mapper.readValue(response.getContentAsString(), TimeTrackEntity.class);

        // when
//        response = retrieveById(entity2.getId());

        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        TimeTrackEntity entityresult = mapper.readValue(response.getContentAsString(), TimeTrackEntity.class);
//        assertThat(dtoresult.getBranch()).isEqualTo("v2");
    }

    @Test
    public void canUpdate() throws Exception {

        // given
//        TimeTrackEntity entity = readFromFile(data + "TimeTrack.json");
//        MockHttpServletResponse response = create(entity);
//        TimeTrackEntity entity2 = mapper.readValue(response.getContentAsString(), TimeTrackEntity.class);

        // when
//        response = update(entity2);

        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        TimeTrackEntity entityresult = mapper.readValue(response.getContentAsString(), TimeTrackEntity.class);
//        assertThat(dtoresult.getBranch()).isEqualTo("v2");
    }

    @Override
    @Test
    public void canDelete() throws Exception {
        // given
//        TimeTrackEntity entity = readFromFile(data + "TimeTrack.json");
//        MockHttpServletResponse response = create(entity);
//        TimeTrackEntity entity2 = mapper.readValue(response.getContentAsString(), TimeTrackEntity.class);
//        response = retrieveById(entity2.getId());
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        // when
//        delete(entity2.getId());

        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        response = retrieveById(entity2.getId());
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

}
