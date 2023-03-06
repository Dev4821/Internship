@RestController
@RequestMapping("/vendors")
public class VendorController {
    
    @Autowired
    private VendorService vendorService;
    
    @PostMapping
    public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
        Vendor createdVendor = vendorService.createVendor(vendor);
        return new ResponseEntity<>(createdVendor, HttpStatus.CREATED);
    }
    
    @PutMapping("/{vendorId}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable Long vendorId, @RequestBody Vendor vendor) {
        Vendor updatedVendor = vendorService.updateVendor(vendorId, vendor);
        return new ResponseEntity<>(updatedVendor, HttpStatus.OK);
    }
    
    @DeleteMapping("/{vendorId}")
    public ResponseEntity<Void> deleteVendor(@PathVariable Long vendorId) {
        vendorService.deleteVendor(vendorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/{vendorId}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable Long vendorId) {
        Vendor vendor = vendorService.getVendorById(vendorId);
        return new ResponseEntity<>(vendor, HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<Vendor>> getAllVendors() {
        List<Vendor> vendors = vendorService.getAllVendors();
        return new ResponseEntity<>(vendors, HttpStatus.OK);
    }
    
    @GetMapping(params = "name")
    public ResponseEntity<Vendor> getVendorByName(@RequestParam String name) {
        Vendor vendor = vendorService.getVendorByName(name);
        return new ResponseEntity<>(vendor, HttpStatus.OK);
    }
    
    @GetMapping(params = "code")
    public ResponseEntity<Vendor> getVendorByCode(@RequestParam String code) {
        Vendor vendor = vendorService.getVendorByCode(code);
        return new ResponseEntity<>(vendor, HttpStatus.OK);
    }
    
    @ExceptionHandler(value = { EntityNotFoundException.class })
    public ResponseEntity<Object> handleNotFoundException(EntityNotFoundException ex, WebRequest request) {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
