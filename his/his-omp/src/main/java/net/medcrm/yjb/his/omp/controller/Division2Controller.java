package net.medcrm.yjb.his.omp.controller;

import net.medcrm.yjb.his.omp.domain.Division;
import net.medcrm.yjb.his.omp.service.Division2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Justin on 2017/10/27.
 */

@RestController
@RequestMapping("/api/division2")
public class Division2Controller {
    @Autowired
    Division2Service division2Service;




}
