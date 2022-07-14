package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.entities.Sales;
import com.devsuperior.dsmeta.services.SalesServices;
import com.devsuperior.dsmeta.services.SmsService;
import com.devsuperior.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;


import java.util.List;


@RestController
@RequestMapping(value = "/sales")
public class SalesController {
    @Autowired
    private SalesServices service;
    @Autowired
    private SmsService smsService;

    @GetMapping
    public Page<Sales> findSales(
            @RequestParam(value="minDate", defaultValue = "") String minDate,
            @RequestParam(value="maxDate", defaultValue = "") String maxDate,
            Pageable pageable){
        return service.findSales(minDate, maxDate, pageable);
    }

    @GetMapping("/{id}/notification")
    public void notifySms(@PathVariable Long id){
        smsService.sendSms(id);
    }
}
