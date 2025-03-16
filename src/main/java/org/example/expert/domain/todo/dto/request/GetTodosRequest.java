package org.example.expert.domain.todo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetTodosRequest {
    private String weather;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public void checkDate() {
        if (startDate != null && endDate != null && startDate.isAfter(endDate)) {
            LocalDateTime tempDate = startDate;
            this.startDate = endDate;
            this.endDate = tempDate;
        }
    }
}
