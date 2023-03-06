public interface VendorService {
    
    Vendor createVendor(Vendor vendor);
    
    Vendor updateVendor(Long vendorId, Vendor vendor);
    
    void deleteVendor(Long vendorId);
    
    Vendor getVendorById(Long vendorId);
    
    List<Vendor> getAllVendors();
    
    Vendor getVendorByName(String vendorName);
    
    Vendor getVendorByCode(String vendorCode);
}
