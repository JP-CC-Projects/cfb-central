// SortableSegmentedTable.tsx
import { useState } from 'react';
import { useReactTable, ColumnDef, getCoreRowModel, getGroupedRowModel, flexRender, getSortedRowModel, SortingState } from '@tanstack/react-table';
import { Player } from '../../../../types/teamTypes';
import styles from './SortableSegmentedTable.module.css';

interface SortableSegmentedTableProps {
  data: Player[];
  columns: ColumnDef<Player>[];
}

const SortableSegmentedTable: React.FC<SortableSegmentedTableProps> = ({ data, columns }) => { // Include columns in the props
  const [sorting, setSorting] = useState<SortingState>([]);

  const table = useReactTable<Player>({
    data,
    columns,
    state: {
      sorting,
    },
    onSortingChange: setSorting,
    getCoreRowModel: getCoreRowModel(),
    getGroupedRowModel: getGroupedRowModel(),
    getSortedRowModel: getSortedRowModel(),
  });

  return (
    <div className={styles.sortableTableContainer}>
      <table className={styles.sortableTable}>
        <thead className={styles.sortableTableThead}>
          {table.getHeaderGroups().map(headerGroup => (
            <tr className={styles.sortableTableRow} key={headerGroup.id}>
              {headerGroup.headers.map(header => (
                <th className={styles.sortableTableTh} key={header.id} onClick={header.column.getToggleSortingHandler()}>
                  {flexRender(header.column.columnDef.header, header.getContext())}
                  <span className={styles.sortIndicator}>
                    {header.column.getIsSorted()
                      ? (header.column.getIsSorted() === 'desc' ? '▼' : '▲')
                      : ' ' /* Non-breaking space */}
                  </span>
                </th>
              ))}
            </tr>
          ))}
        </thead>
        <tbody>
          {table.getRowModel().rows.map(row => (
            <tr className={styles.sortableTableRow} key={row.id}>
              {row.getAllCells().map(cell => {
                if (row.depth > 0 && cell.column.id === row.groupingColumnId) {
                  return (
                    <td className={styles.sortableTableTd} key={cell.id} colSpan={row.getAllCells().length}>
                      {/* Toggle controls or indicators for grouped rows */}
                      {`${row.groupingValue} (${row.subRows.length})`}
                    </td>
                  );
                }
                return (
                  <td className={styles.sortableTableTd} key={cell.id}>
                    {cell.getIsGrouped()
                      ? null // Don't render grouped cells
                      : flexRender(cell.column.columnDef.cell, cell.getContext())}
                  </td>
                );
              })}
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default SortableSegmentedTable;