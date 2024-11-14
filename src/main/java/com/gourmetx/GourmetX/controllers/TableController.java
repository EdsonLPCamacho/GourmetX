package com.gourmetx.GourmetX.controllers;

import com.gourmetx.GourmetX.entities.TableEntity;
import com.gourmetx.GourmetX.services.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping
    public ResponseEntity<List<TableEntity>> getAllTables() {
        List<TableEntity> tables = tableService.getAllTables();
        
        return ResponseEntity.ok(tables);
    }
    
 
}
