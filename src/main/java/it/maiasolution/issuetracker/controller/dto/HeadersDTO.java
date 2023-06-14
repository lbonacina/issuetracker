package it.maiasolution.issuetracker.controller.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class HeadersDTO {    
    
    private Map<String, String> headers;
    private String principal; 
}
