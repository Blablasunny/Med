package com.med.rest.dto;

import com.med.domain.Day;
import com.med.domain.Patient;
import com.med.domain.Write;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DayDto {

    private int id;

    private String date;

    private List<WriteDto> writeDtoList;

    public static DayDto toDto(Day day) {

        List<WriteDto> writeDtos = new ArrayList<>();
        if (day.getWriteList() != null) {
            writeDtos = day.getWriteList()
                    .stream()
                    .map(WriteDto::toDto)
                    .collect(Collectors.toList());
        }else {

            writeDtos = new ArrayList<>();
        }

        return new DayDto(
                day.getId(),
                day.getDate(),
                writeDtos
        );
    }

    public static Day toDomainObject(DayDto dayDto, List<Write> writes) {

        return new Day(
                dayDto.getId(),
                dayDto.getDate(),
                writes
        );
    }
}
