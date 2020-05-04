package ChainOfResponsibility;

public class ViceSchoolMasterApprover extends Approver{

    public ViceSchoolMasterApprover(String name) {
        super(name);
    }
    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {

        if (purchaseRequest.getPrice()>1000&&purchaseRequest.getPrice()<=30000) {
            System.out.println("请求编号id = "+purchaseRequest.getId()+"被 "+this.name+" 处理");
        }else {
            approver.processRequest(purchaseRequest);
        }
    }
}
