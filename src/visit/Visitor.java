package visit;

import model.impl.BookDepartment;
import model.impl.MusicDepartment;
import model.impl.SoftwareDepartment;
import model.impl.VideoDepartment;

public interface Visitor {

    void visit(MusicDepartment musicDepartment);

    void visit(BookDepartment bookDepartment);

    void visit(SoftwareDepartment softwareDepartment);

    void visit(VideoDepartment videoDepartment);
}
