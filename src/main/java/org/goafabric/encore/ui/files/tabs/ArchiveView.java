package org.goafabric.encore.ui.files.tabs;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.upload.SucceededEvent;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import org.goafabric.encore.objectstorage.dto.ObjectEntry;
import org.goafabric.encore.masterdata.logic.CrudLogic;
import org.goafabric.encore.ui.GridView;

import java.io.IOException;

public class ArchiveView extends GridView<ObjectEntry> {
    public ArchiveView(CrudLogic<ObjectEntry> logic) {
        super(new Grid<>(ObjectEntry.class), logic);

        addUpload();
    }

    private void addUpload() {
        var memoryBuffer = new MemoryBuffer();
        var singleFileUpload = new Upload(memoryBuffer);
        singleFileUpload.addSucceededListener(event -> uploadFile(memoryBuffer, event));
        this.add(singleFileUpload);
    }

    private void uploadFile(MemoryBuffer memoryBuffer, SucceededEvent event) {
        try {
            this.getLogic().create(
                    ObjectEntry.builder()
                            .objectName(event.getFileName())
                            .objectSize(event.getContentLength())
                            .contentType(event.getMIMEType())
                            .data(memoryBuffer.getInputStream().readAllBytes())
                            .build()
            );
            updateList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void addColumns(Grid<ObjectEntry> grid) {
        grid.addColumn(ObjectEntry::getObjectName).setHeader("Name");
        grid.addColumn(ObjectEntry::getContentType).setHeader("Type");
        grid.addColumn(ObjectEntry::getObjectSize).setHeader("Size");
    }
}
