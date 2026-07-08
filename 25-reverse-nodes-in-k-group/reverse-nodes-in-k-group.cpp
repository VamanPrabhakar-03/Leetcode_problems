class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        if(k==1 || head==NULL || head->next==NULL) return head;
        ListNode* dummy = new ListNode(0);
        dummy->next=head;

        ListNode* curr = dummy;
        ListNode* prev = dummy;
        ListNode* nex = dummy;

        
        int count = 0;
        while(curr->next){
          count++;
          curr = curr->next;
        }

        while(count >= k){
            curr = prev->next;
            nex = curr->next;

            for(int i=1;i<k;i++){
                curr->next = nex->next;
                nex->next = prev->next;
                prev->next = nex;
                nex = curr->next;
            }
            
            prev = curr;
            count -= k;
        }
        
        head = dummy->next;
        dummy->next = nullptr;
        delete dummy;
        return head;

    }
};