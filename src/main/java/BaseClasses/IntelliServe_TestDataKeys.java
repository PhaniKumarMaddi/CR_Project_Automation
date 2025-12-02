package BaseClasses;

public class IntelliServe_TestDataKeys {

	public String userName = "Phani Kumar Maddi";
	public String ssoUserName = "phani.maddi@criticalriver.com";
	public String ssoPassword = "Rklalitha$67";
	public String login_Url = "/login";

	// Url val

	public String myTicketPage = "/user/tickets";
	public String approverDashboardPage = "/approver/dashboard";
	public String approverWorklistPage = "/approver-tickets";
	public String allTicketsPage = "/tickets";
	public String adminDashboardPage = "/admin";
	public String approverMgmtPage = "/approver-management";
	public String rolesPage = "/roles";
	public String implementationQueuePage = "/implementation-queue";

	// Page title
	public String myTicketTitle = "My Tickets";
	public String approverDashboardTitle = "Approver Dashboard";
	public String approverWorklistTitle = "Approver Worklist";
	public String allTicketsTitle = "All Tickets";
	public String adminDashboardTitle = "Ticketing Dashboard";
	public String approverMgmtTitle = "Approver Management";
	public String rolesTitle = "Roles Management";
	public String implementationQueueTitle = "Implementation Queue";

	// roles
	public String admin_Role = "Admin";
	public String itApprover_Role = "IT Approver";
	public String itMember_Role = "IT Member";
	public String btgApprover_Role = "BTG Approver";
	public String btgMember_Role = "BTG Member";
	public String dept_Approver_Role = "Department Approver";
	public String fianance_Approver_Role = "Finance Approver";
	public String operation_Approver_Role = "Operations Approver";

	// Status
	public String statusFilter = "Status";
	public String selectAllSatusFilter = "Select All";
	public String pending_StatusFilter = "Pending";
	public String approver_StatusFilter = "Approved";
	public String rejected_StatusFilter = "Rejected";
	public String resolved_StatusFilter = "Resolved";
	public String forwarded_StatusFilter = "Forwarded";
	public String implementSchedult_StatusFilter = "Implementation Scheduled";
	public String workInProgress_StatusFilter = "Work Inprogress";
	public String closed_StatusFilter = "Closed";

	// Priority
	public String priorityFilter = "Priority";
	public String high_PriorityFilter = "High";
	public String medium_PriorityFilter = "Medium";
	public String low_PriorityFilter = "Low";
	public String critical_PriorityFilter = "Critical";

	// Department
	public String btg_DepartmentFilter = "Business Technology Group";
	public String dsil_DepartmentFilter = "DSIL";
	public String dsa_DepartmentFilter = "Data Science and AI";
	public String departmentFilter = "Department";
	public String stageFilter = "Stages";
	public String currentStage = "Current Stage";

	// create ticket
	public String limitExceedMsg = "File size should be less than 30 MB.";
	public String invalidFileMsg = "This file type is not supported. Please upload PDF, DOC, DOCX, XLS, XLSX, JPG, PNG, or TXT files only.";

	public String cancelTicket = "Cancel";
	public String createTicket = "Create Ticket";

	// Fields in Ticket Detail Popup

	public String ticketId_InDetailPopup = "Ticket ID";
	public String ticketType_InDetailPopup = "Ticket Type";
	public String status_InDetailPopup = "Status";
	public String stage_InDetailPopup = "Current Stage";
	public String priority_InDetailPopup = "Priority";
	public String requestor_InDetailPopup = "Requestor";
	public String requestorEmail_InDetailPopup = "Requestor Email";
	public String requestorMobile_InDetailPopup="Requestor Mobile";
	public String department_InDetailPopup = "Department";
	public String manager_InDetailPopup = "Manager";
	public String managerEmail_InDetailPopup = "Manager Email";
	public String created_InDetailPopup = "Created";
}