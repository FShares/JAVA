package BAM;

/*
 * ͬʱҪ���дBank��,����:
 1.��ǰ���е��˻�����ļ���,�����������
 2.��ǰ�˻�����
  ����:
 1.�û�����,��Ҫ�Ĳ���:id,����,����ȷ��,����,���֤����,����,�˻�����(int),�����´�����Account���� 
 2.�û���¼,����:id,���� ����Account����,��ʾ ��s1.equals(s2)�ж�s1��s2���� �ַ��������Ƿ����
 3.�û����,����:id,�������,�����޸Ĺ���Account����
 4.�û�ȡ��,����:id,ȡ������,�����޸Ĺ���Account����
 5.����͸֧��� ����:id,�µĶ��  ,�����޸Ĺ���Account����.���������Ҫ��֤�˻��Ƿ��������˻� 
 
 */
public class Bank {
	int Accountlist[];
	int AccountCount=0;

	Account userCreate(long id, String pass, String name, String personID, String email, double balance) {
		Account A1 = new Account();
		AccountCount++;
		return A1;
	}
}
