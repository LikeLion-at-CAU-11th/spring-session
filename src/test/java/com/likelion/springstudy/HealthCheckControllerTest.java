package com.likelion.springstudy;


import com.likelion.springstudy.controller.HealthCheckController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@AutoConfigureRestDocs
@WebMvcTest(HealthCheckController.class)
public class HealthCheckControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Health Check Controller 테스트")
    @Test
    void healthCheckControllerTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/health").header("Content-Type", "application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andDo(MockMvcRestDocumentation.document("health-check-controller/health-check"))
                .andExpect(MockMvcResultMatchers.status().isOk())
        ;
    }
}
