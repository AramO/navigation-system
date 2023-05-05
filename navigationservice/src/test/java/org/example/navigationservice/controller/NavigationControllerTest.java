package org.example.navigationservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.navigationservice.dto.LocationDataDTO;
import org.example.navigationservice.dto.ReportDTO;
import org.example.navigationservice.dto.ReportDataDTO;
import org.example.navigationservice.exception.NotFoundException;
import org.example.navigationservice.service.NavigationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(NavigationController.class)
public class NavigationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NavigationService navigationService;

    @Test
    public void testPostMobileStationReports() throws Exception {
        UUID baseStationId = UUID.randomUUID();
        List<ReportDTO> reports = new ArrayList<>();
        ReportDTO report1 = new ReportDTO(UUID.randomUUID(), 100.0f, LocalDateTime.now());
        ReportDTO report2 = new ReportDTO(UUID.randomUUID(), 200.0f, LocalDateTime.now());
        reports.add(report1);
        reports.add(report2);
        ReportDataDTO reportDataDTO = new ReportDataDTO(baseStationId, reports);

        mockMvc.perform(post("/base-station/report")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(reportDataDTO)))
                .andExpect(status().isCreated());

        verify(navigationService, times(1)).processReportData(reportDataDTO);
    }

    @Test
    public void testGetMobileStationLocation() throws Exception {
        UUID mobileStationId = UUID.randomUUID();
        float x = 100.0f;
        float y = 200.0f;
        float errorRadius = 10.0f;
        int errorCode = 0;
        String errorDescription = "";

        LocationDataDTO locationDataDTO = new LocationDataDTO(mobileStationId, x, y, errorRadius, errorCode, errorDescription);

        when(navigationService.getMobileStationLocation(mobileStationId.toString())).thenReturn(locationDataDTO);

        mockMvc.perform(get("/location/{uuid}", mobileStationId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mobileId").value(mobileStationId.toString()))
                .andExpect(jsonPath("$.x").value(x))
                .andExpect(jsonPath("$.y").value(y))
                .andExpect(jsonPath("$.error_radius").value(errorRadius))
                .andExpect(jsonPath("$.error_code").value(errorCode))
                .andExpect(jsonPath("$.error_description").value(errorDescription));

        verify(navigationService, times(1)).getMobileStationLocation(mobileStationId.toString());
    }

    @Test
    public void testGetMobileStationLocationNotFound() throws Exception {
        UUID mobileStationId = UUID.randomUUID();

        when(navigationService.getMobileStationLocation(mobileStationId.toString())).thenThrow(new NotFoundException("Mobile station not found"));

        mockMvc.perform(get("/location/{uuid}", mobileStationId))
                .andExpect(status().isNotFound());

        verify(navigationService, times(1)).getMobileStationLocation(mobileStationId.toString());
    }
}

