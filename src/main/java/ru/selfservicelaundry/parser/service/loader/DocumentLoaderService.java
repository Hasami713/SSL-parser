package ru.selfservicelaundry.parser.service.loader;

import org.jsoup.nodes.Document;

public interface DocumentLoaderService {
    Document loadLaundryPage(String laundryId);
    Document loadLaundriesPage();
}
