abstract class Document {
	public void save() { /* �洢�ĵ����ݣ��˴�����ʡ�� */}
	public void open(String docName) { /*���ĵ����˴�����ʡ�� */}
	public void close() { /* �ر��ĵ����˴�����ʡ�� */}
	public abstract void read(String docName);
}

abstract class Application {
	private Vector<Document> docs; /*�ĵ����󼯺�*/
	public boolean canOpenDocument(String docName){
		/*�ж��Ƿ���Դ�ָ���ĵ���������ֵʱ��ʾ���Դ򿪣�
		 ���ؼ�ֵ��ʾ���ɴ򿪣��˴�����ʡ��*/
	}
	public void addDocument(Document aDocument){
		/*���ĵ�������ӵ��ĵ����󼯺���*/
		docs.add(aDocument);
	}
	public abstract Document doCreateDocument(); /*����һ���ĵ�����*/
	public void openDocument(String docName) { /*���ĵ�*/
		if(canOpenDocument(docName)) {
			System.out.println("�ĵ��޷��򿪣�");
			return;
		}
		Document adoc = new MyDocument();
		adoc.open(docName);
		adoc.read();
		addDocument(adoc);
	}
}