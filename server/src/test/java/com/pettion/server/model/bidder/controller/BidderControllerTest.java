package com.pettion.server.model.bidder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pettion.server.model.bidder.dto.request.SignupRequest;
import com.pettion.server.model.bidder.dto.response.BidderResponse;
import com.pettion.server.model.bidder.entity.Bidder;
import com.pettion.server.model.bidder.service.BidderService;
import com.pettion.server.testconfig.RestDocsConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@WebMvcTest(BidderController.class)
@Import(RestDocsConfiguration.class)
@AutoConfigureRestDocs
class BidderControllerTest {

    @MockBean
    private BidderService bidderService;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    @DisplayName("[signup]_[회원가입 1회]_[http response]")
    void signupDoSuccess() throws Exception {
        //given
        SignupRequest dto = new SignupRequest("accountId", "password", " nickname");
        Bidder bidder = new Bidder(dto.getAccountId(), dto.getPassword(), dto.getNickname());
        BidderResponse willReturnValue = new BidderResponse(bidder);
        given(bidderService.signup(dto)).willReturn(willReturnValue);

        //when
        ResultActions result = mockMvc.perform(
                post("/api/bidders")
                        .content(objectMapper.writeValueAsString(dto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));
    
        //then
        result.andExpect(status().isCreated())
                .andDo(document("create-member",
                        requestFields(
                                fieldWithPath("accountId").type(JsonFieldType.STRING).description("계정ID"),
                                fieldWithPath("password").type(JsonFieldType.STRING).description("암호"),
                                fieldWithPath("nickname").type(JsonFieldType.STRING).description("닉네임")
                        ),
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("식별번호"),
                                fieldWithPath("accountId").type(JsonFieldType.STRING).description("계정ID"),
                                fieldWithPath("nickname").type(JsonFieldType.STRING).description("닉네임"),
                                fieldWithPath("point").type(JsonFieldType.NUMBER).description("포인트")
                        )
                ));
    
    }
}